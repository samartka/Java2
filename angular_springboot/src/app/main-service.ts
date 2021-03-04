import { User } from './user';

export class MainService {
    public appName: string;
    public user: User;
    public lastUpdate: String;

    constructor() {
        this.appName = "My Angular";
    }

    setupUser(userId: number, firstname: string, lastname: string, email: string, gender: string) {
        this.user = new User(userId, firstname, lastname, email, gender);
    }

    getUser() {
        return this.user;
    }

    setUser(user : User) {
        this.user = user;
    }
}
