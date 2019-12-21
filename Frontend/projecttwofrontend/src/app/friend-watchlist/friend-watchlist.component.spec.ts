import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendWatchlistComponent } from './friend-watchlist.component';

describe('FriendWatchlistComponent', () => {
  let component: FriendWatchlistComponent;
  let fixture: ComponentFixture<FriendWatchlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FriendWatchlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendWatchlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
