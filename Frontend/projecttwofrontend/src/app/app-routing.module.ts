import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddMoviesComponent } from './movies/add-movies/add-movies.component';
import { AddShowsComponent } from './shows/add-shows/add-shows.component';
import { EditMoviesComponent } from './movies/edit-movies/edit-movies.component';
import { EditShowsComponent } from './shows/edit-shows/edit-shows.component';


const routes: Routes = [
  {
  path: '',
  redirectTo: '/home',
  pathMatch: 'full'
},
{
  path:'movies/edit',
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
}





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
