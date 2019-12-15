import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user-list/user-list.component';
import { AddMoviesComponent } from './movies/add-movies/add-movies.component';
import { AddShowsComponent } from './shows/add-shows/add-shows.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { EditMoviesComponent } from './movies/edit-movies/edit-movies.component';
import { EditShowsComponent } from './shows/edit-shows/edit-shows.component';
import { GenreComponent } from './all-shared/genre/genre.component';





@NgModule({
  declarations: [
    AppComponent,

    UserComponent,
    UserListComponent,
    AddMoviesComponent,
    AddShowsComponent,
    MovieListComponent,
    EditMoviesComponent,
    EditShowsComponent,
    GenreComponent

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
