import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserReviewListComponent } from './user-review-list.component';

describe('UserReviewListComponent', () => {
  let component: UserReviewListComponent;
  let fixture: ComponentFixture<UserReviewListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserReviewListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserReviewListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
