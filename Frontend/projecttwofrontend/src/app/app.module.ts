import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

//#region Inports
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MoviesComponent } from './movies/movie-comp/movies.component';
import { SingleMovieComponent } from './movies/single-movie/single-movie.component';
import { UrlService } from './shared/url.service';
import { MoviesService } from './movies/shared/movies.service';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user-list/user-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login.service';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SearchService } from './shared/search.service';
import { AddMoviesComponent } from './movies/add-movies/add-movies.component';
import { AddShowsComponent } from './shows/add-shows/add-shows.component';
import { EditMoviesComponent } from './movies/edit-movies/edit-movies.component';
import { EditShowsComponent } from './shows/edit-shows/edit-shows.component';
import { GenreComponent } from './all-shared/genre/genre.component';
import { MovieratingComponent } from './movierating/movierating/movierating.component';

//#endregion



@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UserListComponent,
    AddUserComponent,
    LoginComponent,
    NavBarComponent,
    MoviesComponent,
    SingleMovieComponent,
    AddMoviesComponent,
    AddShowsComponent,
    EditMoviesComponent,
    EditShowsComponent,
    GenreComponent,
    MovieratingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [
    UrlService,
    MoviesService,
    SearchService,
    LoginService,
    HttpClientModule,
    FormsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
