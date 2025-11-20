import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-card-reto',
  standalone: true,
  templateUrl: './card-reto.html',
  styleUrl: './card-reto.css',
})
export class CardReto {
  @Input() data!: any;
  @Input() selected: boolean = false;
  @Output() select = new EventEmitter<void>();

  onSelect() {
    this.select.emit();
  }
}
