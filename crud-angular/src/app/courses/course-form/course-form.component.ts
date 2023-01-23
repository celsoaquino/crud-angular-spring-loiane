import { CoursesService } from './../services/courses.service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component( {
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private cursoService: CoursesService,
    private _snackBar: MatSnackBar
    ) {
          this.form = this.formBuilder.group( {
            name: [null],
            category: [null]

          });
  }

  onSubmit() {
    this.cursoService.save(this.form.value)
    .subscribe(result =>  console.log(result), error => this.onError());

  }

  onCancel() {
    console.log("cancel")
  }

  private onError() {
    this._snackBar.open('Erro ao salvar curso', '', { duration: 5000 });
  }
}
