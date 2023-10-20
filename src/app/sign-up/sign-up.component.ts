import { Component } from '@angular/core';

import Swal from 'sweetalert2'; // Importez SweetAlert2
import { User } from '../models/user.model';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
})
export class SignUpComponent {
  user: User = {
    name: '',
    contactNumber: '',
    email: '',
    password: '',
  };

  constructor(private authService: AuthService) {}

  signUp() {
    // Récupérez le token JWT du localStorage (ou d'où vous le stockez)
    const token = localStorage.getItem('token');

    if (!token) {
      // Gérez l'absence de token, par exemple, en redirigeant l'utilisateur vers la page de connexion
      Swal.fire({
        icon: 'error',
        title: 'Erreur',
        text: 'Vous devez être connecté en tant que administrateur pour effectuer cette action.'
      });
      return;
    }

    // Créez un en-tête pour inclure le token JWT
    const headers = { Authorization: `Bearer ${token}` };

    // Effectuez la requête HTTP avec le token dans l'en-tête
    this.authService.signUp(this.user, headers).subscribe(
      (response) => {
        Swal.fire({
          icon: 'success',
          title: 'Inscription réussie',
          text: 'L\'utilisateur a été enregistré avec succès.'
        });

        console.log('Utilisateur enregistré:', response);
      },
      (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Enregistrement non autorisé',
          text: "Vous n/'êtes pas autorisé à enregistrer un utilisateur ."
        });

        console.error('Erreur lors de l\'enregistrement de l\'utilisateur:', error);
      }
    );
  }
}

