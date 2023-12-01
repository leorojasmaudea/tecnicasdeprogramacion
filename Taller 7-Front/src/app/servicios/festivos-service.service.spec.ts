import { TestBed } from '@angular/core/testing';

import { FestivosServiceService } from './festivos-service.service';

describe('FestivosServiceService', () => {
  let service: FestivosServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FestivosServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
