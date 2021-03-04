import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MainService } from '../main-service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  form: FormGroup;
  @Input()
  title: string;
  @Input()
  mainService : MainService;
  constructor(private fb: FormBuilder, private http: HttpClient) {
    
    this.form = this.fb.group({
      firstname: 'a',
      lastname: 'b',
      email: 'c',
      gender: 'male'
    }); 
  }

  ngOnInit() {
    console.log("update-profile.component.ts called : " + this.title);
  }

  submitForm() {
    const payload : FormData = new FormData();

    payload.append("user_id", "2");
    payload.append("firstname", this.form.get("firstname").value);
    payload.append("lastname", this.form.get("lastname").value);
    payload.append("email", this.form.get("email").value);
    payload.append("gender", this.form.get("gender").value);
    
    // payload.append("user_id", "2");
    // payload.append("firstname", "aaa");
    // payload.append("lastname", "bbb");
    // payload.append("email", "c@c.com");
    // payload.append("gender", "female");

    this.http
      .post('http://localhost:8555/api/updateProfile',payload)
      .subscribe(result => {
        alert(JSON.stringify(result));
      });
  }
}
