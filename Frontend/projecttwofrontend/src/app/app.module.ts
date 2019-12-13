import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movie-comp/movies.component';
import { SingleMovieComponent } from './movies/single-movie/single-movie.component';
import { UrlService } from './shared/url.service';
import { MoviesService } from './movies/shared/movies.service';

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    SingleMovieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
  UrlService,
  MoviesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
