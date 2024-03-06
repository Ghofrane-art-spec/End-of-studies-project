import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LocalService } from 'src/app/local.service';
import { UserserviceService } from 'src/app/userservice.service';

@Component({
  selector: 'app-ajouter-client',
  templateUrl: './ajouter-client.component.html',
  styleUrls: ['./ajouter-client.component.css']
})
export class AjouterClientComponent {
  nom!:any;
  prenom!:any; 
  ngOnInit(): void {
    this.nom=this.localStore.getData('nom');
    this.prenom=this.localStore.getData('prenom');
    let data=this.localStore.getData('role');
    if(data=="0"){
      this.router.navigate(["/"]);
    }else if(data=="1"){
      this.router.navigate(["/agence"]);
    }else if(data=="2"){
      this.router.navigate(["/encaissement"]);
    }else if(data=="3"){
      this.router.navigate(["/ajouterClient"]);
    }else{
      this.router.navigate(["/client"]);
    }
  }
  nomClient!:String;
  prenomClient!:String;
  numeroTelephone!:Number;
  mailClient!:String;
  matricule!:Number;
  Deconnexion(){
    this.localStore.saveData('role',"0");
    location.reload();
  }

  constructor(private us:UserserviceService,private router:Router,private localStore:LocalService){}

  status: boolean = false;
   clickEvent(){
       this.status = !this.status; }
       valider(){
        
       }

}
