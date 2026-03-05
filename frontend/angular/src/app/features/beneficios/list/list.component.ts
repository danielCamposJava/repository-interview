import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Beneficio } from 'src/app/shared/models/beneficio.model';
import { BeneficioService } from 'src/app/core/services/beneficio.service';

@Component({
  selector: 'app-list-beneficio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list.component.html'
})
export class BeneficioListComponent implements OnInit {
  beneficios: Beneficio[] = [];

  constructor(private beneficioService: BeneficioService) {}

  ngOnInit(): void {
    this.beneficioService.getAll().subscribe(data => this.beneficios = data);
  }
}