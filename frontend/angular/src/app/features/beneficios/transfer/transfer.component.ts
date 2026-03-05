import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BeneficioService } from 'src/app/core/services/beneficio.service';

@Component({
  selector: 'app-transfer-beneficio',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './transfer.component.html'
})
export class BeneficioTransferComponent {
  fromId!: number;
  toId!: number;
  amount!: number;
  message = '';

  constructor(private beneficioService: BeneficioService) {}

  transfer() {
    this.beneficioService.transfer(this.fromId, this.toId, this.amount).subscribe({
      next: () => this.message = 'Transferência realizada com sucesso!',
      error: err => this.message = 'Erro: ' + err.message
    });
  }
}