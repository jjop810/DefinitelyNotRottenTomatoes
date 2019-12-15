import { Genre } from 'src/app/all-shared/genre-shared/genre';

export class Movies {

    id:number;
    title:string;
    movieLength:number;
    rating:number;
    imgUrl:string;
    genres:Genre[];
}
