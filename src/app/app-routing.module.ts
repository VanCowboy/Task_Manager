import { TasksComponent } from './views/tasks/tasks.component';
import { LoginComponent } from './views/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';

const routes: Routes = [
{path: 'login', component: LoginComponent},
{path: 'tasks', component: TasksComponent},
{path: '', redirectTo: 'login', pathMatch: 'full'},
{path: '**', redirectTo: 'login'}
];

@NgModule({
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
