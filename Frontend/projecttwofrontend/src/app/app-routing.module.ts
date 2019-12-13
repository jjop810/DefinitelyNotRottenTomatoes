import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddMoviesComponent } from './movies/add-movies/add-movies.component';
import { AddShowsComponent } from './shows/add-shows/add-shows.component';


const routes: Routes = [
  {
  path: '',
  redirectTo: '/home',
  pathMatch: 'full'
},
{
  path: 'movies/add',
  component: AddMoviesComponent
},
{
  path: 'shows/add',
  component: AddShowsComponent
}





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
