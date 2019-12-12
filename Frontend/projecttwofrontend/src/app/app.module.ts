import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MoviesComponent } from './movies/movies.component';
import { ShowsComponent } from './shows/shows.component';
import { MovieListComponent } from './movie-list/movie-list.component';
=======
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user-list/user-list.component';
>>>>>>> 0882ede99d86b4ba9adf2ab4f1349a0793f4c029

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    MoviesComponent,
    ShowsComponent,
    MovieListComponent
=======
    UserComponent,
    UserListComponent
>>>>>>> 0882ede99d86b4ba9adf2ab4f1349a0793f4c029
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
<<<<<<< HEAD
=======
    
>>>>>>> 0882ede99d86b4ba9adf2ab4f1349a0793f4c029
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
