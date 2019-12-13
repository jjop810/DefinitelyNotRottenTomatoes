import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  private static readonly MONOLITH_URL = 'http://localhost:8080/DefinetlyNotRottenTomatos';
  constructor() { }
  public getUrl(): string {
    return UrlService.MONOLITH_URL;
  }
}
