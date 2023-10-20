import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  credentials: { email: string, password: string } = { email: '', password: '' };

  constructor(private authService: AuthService, 
    private router: Router) {}

    login() {
      this.authService.login(this.credentials).subscribe(
        (response: any) => {
          if (response.token) {
            // Stockez le jeton JWT dans le localStorage ou utilisez un service de gestion des jetons
            localStorage.setItem('token', response.token);
  
            // Afficher une alerte de succès avec SweetAlert
            Swal.fire({
              icon: 'success',
              title: 'Connexion réussie',
              text: 'Vous êtes connecté avec succès.'
            }).then(() => {
              // Redirigez l'utilisateur vers la page signup
              this.router.navigate(['/home']);
            });
          } else {
            // Afficher une alerte d'erreur avec SweetAlert en cas d'échec de l'authentification
            Swal.fire({
              icon: 'error',
              title: 'Erreur d\'authentification',
              text: 'Vérifiez vos identifiants et réessayez.'
            });
          }
        },
        (error) => {
          // Gérez les erreurs d'authentification ici
          console.error('Erreur lors de la connexion', error);
  
          // Afficher une alerte d'erreur avec SweetAlert en cas d'erreur HTTP
          Swal.fire({
            icon: 'error',
            title: 'Erreur lors de la connexion',
            text: 'Une erreur s\'est produite lors de la connexion.'
          });
        }
      );
    }

}
