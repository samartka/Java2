import { Component, OnInit, Input } from '@angular/core';
import { MainService } from '../main-service';
import { User } from '../user'

@Component({
  selector: 'app-current-user-profile',
  templateUrl: './current-user-profile.component.html',
  styleUrls: ['./current-user-profile.component.css']
})
export class CurrentUserProfileComponent implements OnInit {
  @Input()
  mainService: MainService;
  user: User;
  constructor() { }

  ngOnInit() {
    
  }

}
