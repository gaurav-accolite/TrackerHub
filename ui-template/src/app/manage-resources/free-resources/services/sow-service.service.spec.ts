import { TestBed, inject } from '@angular/core/testing';

import { SowServiceService } from './sow-service.service';

describe('SowServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SowServiceService]
    });
  });

  it('should be created', inject([SowServiceService], (service: SowServiceService) => {
    expect(service).toBeTruthy();
  }));
});
