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
import { UratingListComponent } from './movierating/urating-list/urating-list.component';
import { RatingComponent } from './movierating/rating/rating.component';
import { AddMoviereviewComponent } from './movies/add-moviereview/add-moviereview.component';
import { ReviewService } from './all-shared/review-shared/review.service';
import { ReviewComponent } from './all-shared/review/review.component';
import { UserReviewListComponent } from './movies/user-review-list/user-review-list.component';
import { ReviewsComponent } from './all-shared/review-shared/reviews/reviews.component';
import { ShowGuestReviewComponent } from './all-shared/review-shared/show-guest-review/show-guest-review.component';
import { GuestReviewsComponent } from './all-shared/review-shared/guest-reviews/guest-reviews.component';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { AddFriendComponent } from './add-friend/add-friend.component';
import { FriendService } from './friend.service';
import { FriendWatchlistComponent } from './friend-watchlist/friend-watchlist.component';

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
    AddMoviereviewComponent,
    AddShowsComponent,
    EditMoviesComponent,
    EditShowsComponent,
    GenreComponent,
    MovieratingComponent,
    UratingListComponent,
    RatingComponent,
    AddMoviereviewComponent,
    ReviewComponent,
    UserReviewListComponent,
    ReviewsComponent,
    ShowGuestReviewComponent,
    GuestReviewsComponent,
    WatchlistComponent,
    AddFriendComponent,
    FriendWatchlistComponent
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
    ReviewService,
    FormsModule,
    FriendService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
