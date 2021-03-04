import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MainService } from '../main-service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users = [];
  @Input()
  mainService : MainService;
  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.mainService = new MainService();
    this.userList();
  }

  userList() {
    this.http
      //.get('https://jsonplaceholder.typicode.com/users')
      .get('http://localhost:8555/api/getUserAll')
      .subscribe(result => {
        this.users = result as any[];
      });
  }

  viewDetail(user) {
    alert(JSON.stringify(user));
  }

  loginAsUser(user) {
    this.mainService.setupUser(user.userId, user.firstname, user.lastname, user.email, user.gender);
  }
}
