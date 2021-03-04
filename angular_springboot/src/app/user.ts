export class User {
    public userId: number;
    public firstName: string;
    public lastName: string;
    public email: string;
    public gender: string;

    constructor(userId: number, firstname: string, lastname: string, email: string, gender: string) {
        this.userId = userId;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.gender = gender;
    }
}
