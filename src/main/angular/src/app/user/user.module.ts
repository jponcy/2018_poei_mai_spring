import { UserService } from './user.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListComponent } from './user-list/user-list.component';
import { HttpClientModule } from '@angular/common/http';

const exportedComponents = [
  UserListComponent
];

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  declarations: exportedComponents,
  exports: exportedComponents,
  providers: [
    UserService
  ]
})
export class UserModule { }
