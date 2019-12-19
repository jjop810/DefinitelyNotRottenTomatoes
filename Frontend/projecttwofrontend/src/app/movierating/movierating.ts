import { User } from '../user';
import { Movies } from '../movies/shared/movies';

export class Movierating {
    id: number;
    user: User;
    movie: Movies;
    ratingvalue: number;
}

