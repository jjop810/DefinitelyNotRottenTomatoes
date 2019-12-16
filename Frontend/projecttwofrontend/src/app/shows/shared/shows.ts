import { Genre } from 'src/app/all-shared/genre-shared/genre';

export class Shows {

    id: number;
	title: string;
	episodes: number;
	rating: number;
	imgUrl: string;
	genres:Genre[];

}
