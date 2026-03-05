import { Routes } from '@angular/router';
import { BeneficioListComponent } from './features/beneficios/list/list.component';
import { BeneficioTransferComponent } from './features/beneficios/transfer/transfer.component';

export const appRoutes: Routes = [
  { path: 'beneficios', component: BeneficioListComponent },
  { path: 'transfer', component: BeneficioTransferComponent },
  { path: '', redirectTo: 'beneficios', pathMatch: 'full' }
];