import {Routes} from "@angular/router";
import {CoursesComponent} from "./conteiners/courses/courses.component";
import {CourseFormComponent} from "./conteiners/course-form/course-form.component";
import {CourseResolver} from "./guards/course.resolver";

export const COURSES_ROUTES: Routes = [
  { path: '', component: CoursesComponent },
  { path: 'new', component: CourseFormComponent, resolve: { course: CourseResolver} },
  { path: 'edit/:id', component: CourseFormComponent, resolve: { course: CourseResolver} }
];
