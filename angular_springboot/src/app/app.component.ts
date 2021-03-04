import { Component, Input } from '@angular/core';
import { MainService } from './main-service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'codecampfinal';
  @Input()
  mainService : MainService;

  constructor() {
    this.mainService = new MainService();
  }
}
