import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultObjectVoComponent } from './result-object-vo.component';

describe('ResultObjectVoComponent', () => {
  let component: ResultObjectVoComponent;
  let fixture: ComponentFixture<ResultObjectVoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultObjectVoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultObjectVoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
