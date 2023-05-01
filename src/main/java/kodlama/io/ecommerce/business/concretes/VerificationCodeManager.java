package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.VerificationCodeService;
import kodlama.io.ecommerce.business.dto.responses.create.CreateVerificationCodeResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetVerificationCodeResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllVerificationCodesResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateVerificationCodeResponse;
import kodlama.io.ecommerce.business.dto.requests.create.CreateVerificationCodeRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateVerificationCodeRequest;
import kodlama.io.ecommerce.business.rules.VerificationCodeBusinessRules;
import kodlama.io.ecommerce.entities.concretes.VerificationCode;
import kodlama.io.ecommerce.repository.VerificationCodeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VerificationCodeManager implements VerificationCodeService {
    private final ModelMapper mapper;
  	private VerificationCodeRepository repository;
      private final VerificationCodeBusinessRules rules;

    @Override
    public List<GetAllVerificationCodesResponse> getAll() {
        List<VerificationCode> verificationCodes = repository.findAll();
        List<GetAllVerificationCodesResponse> response = verificationCodes
                .stream()
                .map(verificationCode -> mapper.map(verificationCode, GetAllVerificationCodesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetVerificationCodeResponse getById(int id) {
        return null;
    }

    @Override
    public CreateVerificationCodeResponse add(CreateVerificationCodeRequest request) {
        return null;
    }

    @Override
    public UpdateVerificationCodeResponse update(int id, UpdateVerificationCodeRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }


/*
	@Override
	public DataResult<List<VerificationCode>> getAll() {
		return new SuccessDataResult<List<VerificationCode>>(this.VerificationCodeDao.findAll(),"Data listelendi..");
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		this.VerificationCodeDao.save(verificationCode);
		return new SuccessResult("VerificationCode added..");
	}*/

}
