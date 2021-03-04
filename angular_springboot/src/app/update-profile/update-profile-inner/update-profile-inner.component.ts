import { Component, OnInit, Input } from '@angular/core';
import { MainService } from '../../main-service';

@Component({
  selector: 'app-update-profile-inner',
  templateUrl: './update-profile-inner.component.html',
  styleUrls: ['./update-profile-inner.component.css']
})
export class UpdateProfileInnerComponent implements OnInit {
  @Input()
  title: string;
  @Input()
  mainService: MainService;
  constructor() { }

  ngOnInit() {
    console.log("update-profile-inner.component.ts called : " + this.title);
  }

}
