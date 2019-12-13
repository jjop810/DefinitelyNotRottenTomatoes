import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user-list/user-list.component';
import { AddMoviesComponent } from './add-movies/add-movies.component';
import { ShowsComponent } from './shows/shows.component';
import { MovieListComponent } from './movie-list/movie-list.component';





@NgModule({
  declarations: [
    AppComponent,

    UserComponent,
    UserListComponent,
    AddMoviesComponent,
    ShowsComponent,
    MovieListComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
