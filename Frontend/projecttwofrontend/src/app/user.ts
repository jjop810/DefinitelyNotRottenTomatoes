import { Friend } from './friend';

export class User {
    id: string;
    username: string;
    password: string;
    email: string;
    friends: Friend[]; 
}
