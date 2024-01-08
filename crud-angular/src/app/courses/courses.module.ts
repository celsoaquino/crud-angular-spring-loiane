import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';



import { CoursesListComponent } from './components/courses-list/courses-list.component';
import { CourseFormComponent } from './conteiners/course-form/course-form.component';
import { CoursesComponent } from './conteiners/courses/courses.component';
import { CoursesRoutingModule } from './courses-routing.module';

@NgModule({
    imports: [
    CommonModule,
    CoursesRoutingModule,
    ReactiveFormsModule,
    CoursesComponent,
    CourseFormComponent,
    CoursesListComponent
],
})
export class CoursesModule {}
