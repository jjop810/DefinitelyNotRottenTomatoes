import { Review } from './all-shared/review-shared/review';

export class User {
    id: string;
    username: string;
    password: string;
    email: string;

    reviews:Review[];
}
