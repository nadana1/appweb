import {Component, OnDestroy} from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { takeWhile } from 'rxjs/operators' ;
import { SolarData } from '../../@core/data/solar';
import { LocalDataSource } from 'ng2-smart-table';
import { SmartTableData } from '../../@core/data/smart-table';


@Component({
  selector: 'ngx-dashboard',
  styleUrls: ['./dashboard.component.scss'],
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnDestroy {
  settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    columns: {
      id: {
        title: 'ID',
        type: 'number',
      },
      firstName: {
        title: 'company name',
        type: 'string',
      },
      lastName: {
        title: 'Domain',
        type: 'string',
      },
     
      email: {
        title: 'site',
        type: 'string',
      },
      age: {
        title: 'score',
        type: 'number',
      },
      username: {
        title: 'Decision',
        type: 'string',
      }
    },
  };



  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }

  private alive = true;

  solarValue: number;
  
  statusCards: string;

  

  source: LocalDataSource = new LocalDataSource();
  constructor(private themeService: NbThemeService,
              private solarService: SolarData,private service: SmartTableData) {
                const data = this.service.getData();
                this.source.load(data);
                this.themeService.getJsTheme() .pipe(takeWhile(() => this.alive))
      ;

    this.solarService.getSolarData()
      .pipe(takeWhile(() => this.alive))
      .subscribe((data) => {
        this.solarValue = data;
      });
  }

  ngOnDestroy() {
    this.alive = false;
  }
}
