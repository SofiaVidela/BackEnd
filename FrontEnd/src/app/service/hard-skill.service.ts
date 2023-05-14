import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HardSkill } from '../model/hard-skill';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HardSkillService {
  URL = environment.URL + 'hS';

  constructor(private httpClient: HttpClient) { }
  public lista(): Observable<HardSkill[]> {
    return this.httpClient.get<HardSkill[]>(this.URL + '/lista');
  }
  public detail(id: number): Observable<HardSkill> {
    return this.httpClient.get<HardSkill>(this.URL + `/detail/${id}`);
  }
  public save(hardSkill: HardSkill): Observable<any> {
    return this.httpClient.post<any>(this.URL + '/create', hardSkill);
  }
  public update(id: number,hardSkill: HardSkill): Observable<any> {
    return this.httpClient.put<any>(this.URL + `/update/${id}`,hardSkill);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.URL + `/delete/${id}`);
  }
}
