import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviesComponent } from './movies/movie-comp/movies.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UserComponent } from './user/user.component';
import { AddMoviesComponent } from './movies/add-movies/add-movies.component';
import { AddShowsComponent } from './shows/add-shows/add-shows.component';
import { EditMoviesComponent } from './movies/edit-movies/edit-movies.component';
import { EditShowsComponent } from './shows/edit-shows/edit-shows.component';
import { AddMoviereviewComponent } from './movies/add-moviereview/add-moviereview.component';
import { UserReviewListComponent } from './movies/user-review-list/user-review-list.component';
import { ShowGuestReviewComponent } from './all-shared/review-shared/show-guest-review/show-guest-review.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: MoviesComponent
  },
  {
    path: 'createuser',
    component: UserComponent
  },
  {
    path: 'movies/edit/:id',
    component: EditMoviesComponent
  },
  {
    path: 'movies/add',
    component: AddMoviesComponent
  },
  {
    path: 'shows/add',
    component: AddShowsComponent
  },
  {
    path: 'shows/edit',
    component: EditShowsComponent
  },
  {
    path: 'movies/review/:id',
    component: AddMoviereviewComponent
  },
  {
    path: 'myreview',
    component: UserReviewListComponent
  },
  {
    path: 'movies/review/view/:id',
    component: ShowGuestReviewComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
