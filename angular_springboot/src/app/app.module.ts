import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UpdateProfileInnerComponent } from './update-profile/update-profile-inner/update-profile-inner.component';
import { CurrentUserProfileComponent } from './current-user-profile/current-user-profile.component';

@NgModule({
  declarations: [AppComponent, UserListComponent, UpdateProfileComponent, UpdateProfileInnerComponent, CurrentUserProfileComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
