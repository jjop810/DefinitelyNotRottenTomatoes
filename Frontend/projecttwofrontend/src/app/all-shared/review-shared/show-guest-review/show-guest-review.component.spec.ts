import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowGuestReviewComponent } from './show-guest-review.component';

describe('ShowGuestReviewComponent', () => {
  let component: ShowGuestReviewComponent;
  let fixture: ComponentFixture<ShowGuestReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowGuestReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowGuestReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
