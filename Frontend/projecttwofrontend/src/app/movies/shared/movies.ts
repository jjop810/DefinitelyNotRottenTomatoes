import { Genre } from './genre';

export class Movies {
  id: number;
  title: string;
  movieLength: number;
  rating: number;
  imgUrl: string;
  genres: Genre[];
}
