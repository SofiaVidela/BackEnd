import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SoftSkill } from '../model/soft-skill';

@Injectable({
  providedIn: 'root'
})
export class SoftSkillService {
  URL = environment.URL + 'sS';
  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<SoftSkill[]> {
    return this.httpClient.get<SoftSkill[]>(this.URL + '/lista');
  }
  public detail(id: number): Observable<SoftSkill> {
    return this.httpClient.get<SoftSkill>(this.URL + `/detail/${id}`);
  }
  public save(softSkill: SoftSkill): Observable<any> {
    return this.httpClient.post<any>(this.URL + '/create', softSkill);
  }
  public update(id: number, softSkill: SoftSkill): Observable<any> {
    return this.httpClient.put<any>(this.URL + `/update/${id}`, softSkill);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.URL + `/delete/${id}`);
  }
}
