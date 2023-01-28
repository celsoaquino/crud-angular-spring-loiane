import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';
import { AppMaterialModule } from './app-material/app-material.module';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { CategoryPipe } from './pipes/category.pipe';



@NgModule({
  declarations: [
    ErrorDialogComponent,
    CategoryPipe,
    ConfirmationDialogComponent
  ],
  imports: [
    AppMaterialModule,
    CommonModule
  ],
  exports: [
  ErrorDialogComponent,
  CategoryPipe,
  ConfirmationDialogComponent
]
})
export class SharedModule { }
