import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './views/login/login.component';
import { TasksComponent } from './views/tasks/tasks.component';
import { ResultObjectVoComponent } from './app/vo/result-object-vo/result-object-vo.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TasksComponent,
    ResultObjectVoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
