import { TestBed } from '@angular/core/testing';

import { MrserviceService } from './mrservice.service';

describe('MrserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MrserviceService = TestBed.get(MrserviceService);
    expect(service).toBeTruthy();
  });
});
