import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { SharedModule } from './../shared/shared.module';
import { CoursesListComponent } from './components/courses-list/courses-list.component';
import { CourseFormComponent } from './conteiners/course-form/course-form.component';
import { CoursesComponent } from './conteiners/courses/courses.component';
import { CoursesRoutingModule } from './courses-routing.module';

@NgModule({
  declarations: [
    CoursesComponent,
    CourseFormComponent,
    CoursesListComponent
  ],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule,
    SharedModule
  ],
})
export class CoursesModule {}
