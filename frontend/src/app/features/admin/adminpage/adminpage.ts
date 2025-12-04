import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-adminpage',
  standalone: true,
  templateUrl: './adminpage.html',
  styleUrl: './adminpage.css',
  imports: [
    RouterLink
  ]
})
export class Adminpage {

}
