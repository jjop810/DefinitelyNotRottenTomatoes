import { User } from 'src/app/user';
import { MoviesService } from 'src/app/movies/shared/movies.service';
import { Movies } from 'src/app/movies/shared/movies';

export class Review {

    id:number;
    review:string;
    user:User;
    movie:Movies;
}
