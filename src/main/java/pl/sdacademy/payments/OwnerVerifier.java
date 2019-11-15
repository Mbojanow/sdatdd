package pl.sdacademy.payments;

public class OwnerVerifier {

    public void verify(final Owner owner) {
        if (owner.getFirstName() == null || owner.getFirstName().length() != 0) {
            throw new OwnerException("Owner first name is mandatory");
        }

        if (owner.getLastName() == null || owner.getLastName().length() != 0) {
            throw new OwnerException("Owner last name is mandatory");
        }
    }
}
