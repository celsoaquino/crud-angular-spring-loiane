import { MatSnackBar } from '@angular/material/snack-bar';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Course } from '../../model/course';
import { CoursesService } from '../../services/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent {

  courses$: Observable<Course[]> | null = null;

  constructor(
    private couseService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
    this.refresh();
  }

  refresh() {
    this.courses$ = this.couseService.list().pipe(
      catchError((error) => {
        console.log(error);
        this.onError('Erro ao carregar cursos.');
        return of([]);
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }

  onEdit(course: Course) {
    this.router.navigate(['edit', course._id], { relativeTo: this.route });
  }

  onRemove(course: Course) {
    this.couseService.remove(course._id).subscribe(() => {
      this.refresh();
      this.snackBar.open('Curso removido com sucesso!', 'X', {
        duration: 5000,
        verticalPosition: 'top',
        horizontalPosition: 'center',
      });
    },
    () => this.onError('Erro ao tentar remove curso.') );
  }
}
