import { User } from './../user';
import { Component, OnInit } from '@angular/core';
import { UserService } from './../user.service';
// import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  entities: User[];
  unloaded: boolean;

  constructor(private api: UserService) { }

  ngOnInit() {
    this.unloaded = true;

    this.api.getAll()
      // .tap(_ => this.unloaded = false)
      .subscribe(
        (data) => {
          this.entities = data;
          this.unloaded = false;
        },
        (error: string) => console.error('Error: ', error));
  }
}
